
package com.opcoach.navigator;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Composite;

import com.opcoach.navigator.VersionProvider.LibDescriptor;

public class VersionsPart {

	private TableViewer tableViewer;

	@Inject
	public VersionsPart() {

	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		tableViewer = new TableViewer(parent);
		tableViewer.getTable().setHeaderVisible(true);
		tableViewer.getTable().setLinesVisible(true);
		tableViewer.setContentProvider(new VersionProvider());

		TableViewerColumn c1 = new TableViewerColumn(tableViewer, SWT.NONE);
		c1.getColumn().setText("Filename");
		c1.getColumn().setWidth(120);
		c1.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				return ((LibDescriptor) element).filename;
			}
		});

		TableViewerColumn c2 = new TableViewerColumn(tableViewer, SWT.NONE);
		c2.getColumn().setText("Version");
		c2.getColumn().setWidth(40);
		c2.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				return ((LibDescriptor) element).version;
			}
		});

		TableViewerColumn c3 = new TableViewerColumn(tableViewer, SWT.NONE);
		c3.getColumn().setText("Description");
		c3.getColumn().setWidth(400);
		c3.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {

				return ((LibDescriptor) element).description;
			}
		});

		tableViewer.setInput(new File("/tmp"));

		// Add drag and drop on table
		DragSource ds = new DragSource(tableViewer.getTable(), DND.DROP_COPY);
		ds.setTransfer(new Transfer[] { TextTransfer.getInstance() });
		ds.addDragListener(new DragSourceAdapter() {
			
			@Override
			public void dragSetData(DragSourceEvent event) {
				
					if (TextTransfer.getInstance().isSupportedType(event.dataType))
						event.data = ((LibDescriptor) tableViewer.getTable().getSelection()[0].getData()).filename;
				}
		
		});

	}

	@Inject
	public void reactOnSelect(@Named(IServiceConstants.ACTIVE_SELECTION) File f) {
		if (tableViewer != null)
			tableViewer.setInput(f);

	}

}