
package com.opcoach.navigator.handlers;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.jface.preference.PreferenceManager;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;

import com.opcoach.navigator.pref.LibraryRootPrefPage;

public class OpenPreferences {

	@Execute
	public void execute(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell, IWorkbench wb) {
		PreferenceManager pm = wb.getPreferenceManager();
		PreferenceDialog dialog = new PreferenceDialog(shell, pm);
		dialog.create();
		dialog.getTreeViewer().setComparator(new ViewerComparator());
		dialog.setSelectedNode(LibraryRootPrefPage.ID);
		dialog.open();
	}

}