package com.opcoach.navigator.pref;

import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.opcoach.navigator.NavigatorActivator;

public class LibraryRootPrefPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	
	public static final String ID = "com.opcoach.navigator.libraries.prefpage";
	
	public static final String PREF_PATH_LIB = "PREF_PATH_LIB";

	public LibraryRootPrefPage() {
		super(GRID);
		setPreferenceStore(NavigatorActivator.getInstance().getPreferenceStore());
	}

	

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		addField(new DirectoryFieldEditor(PREF_PATH_LIB, "Library Directory", getFieldEditorParent()));
	}

}
