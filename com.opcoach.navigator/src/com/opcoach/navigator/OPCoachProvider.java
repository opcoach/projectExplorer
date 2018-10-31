package com.opcoach.navigator;

import java.io.File;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;

import com.opcoach.navigator.pref.LibraryRootPrefPage;

public class OPCoachProvider extends LabelProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		// Get files in the preference directory for library
		String path = NavigatorActivator.getInstance().getPreferenceStore().getString(LibraryRootPrefPage.PREF_PATH_LIB);
		if (path != null)
			return new Object[] {new File(path) };
		else 
				return java.io.File.listRoots();
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof File) {
			return ((File) parentElement).listFiles();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof File)
			return ((File) element).getParent();
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof File)
			return ((File) element).isDirectory();
		return false;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof File)
			return ((File) element).getName();
		return super.getText(element);
	}
}
