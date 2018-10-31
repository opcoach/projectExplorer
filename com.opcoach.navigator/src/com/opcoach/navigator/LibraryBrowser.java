 
package com.opcoach.navigator;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import com.opcoach.navigator.pref.LibraryRootPrefPage;

/**
 * The POJO Part to display a file browser from a Library Path defined in preferences 
 * 
 * @author olivier
 *
 */
public class LibraryBrowser {
	
	public static final String ID = "com.opcoach.navigator.libraryBrowser";  // As defined in fragment.e4xmi
	
	private TreeViewer tv; 
	
	@Inject
	public LibraryBrowser() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent, ESelectionService selService) {
		tv = new TreeViewer(parent);
		OPCoachProvider provider = new OPCoachProvider();
		tv.setContentProvider(provider);
		tv.setLabelProvider(provider);
	
		tv.setInput("dummy");  // Preference will be loaded in Provider (see setContents)
		
		tv.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection sel = event.getStructuredSelection();
				selService.setSelection(sel.size() == 1 ? sel.getFirstElement() : sel.toArray());
				
			}
		});
	}
	
	
	@Inject
	public void modifPref(@Preference(value=LibraryRootPrefPage.PREF_PATH_LIB) String path)
	{
		if (tv != null)
			tv.refresh();
	}
	
	
	
	
}