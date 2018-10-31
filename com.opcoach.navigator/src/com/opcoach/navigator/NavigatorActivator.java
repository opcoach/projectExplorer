package com.opcoach.navigator;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/** Activator to get the preference Store */
public class NavigatorActivator extends AbstractUIPlugin {
	
	private static NavigatorActivator instance;

	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		super.start(context);
		instance = this;
	}
	
	public static NavigatorActivator getInstance() {
		return instance;
	}	
	
	

}
