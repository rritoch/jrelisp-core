package com.vnetpublishing.jrelisp.core;

import com.vnetpublishing.lisp.clapi.ILispDispatcher;
import com.vnetpublishing.lisp.clapi.ILispImpl;

public class Dispatcher {

	ILispDispatcher dispatcher;
	
	public Dispatcher(String impl) {
		try {
			this.dispatcher = (ILispDispatcher)(Class.forName(impl).newInstance());
		} catch (InstantiationException e) {
			throw new RuntimeException("Implementation Dispatcher not found",e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException("Implementation Dispatcher not found",e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Implementation Dispatcher not found",e);
		}
	}
	
	public ILispImpl dispatch(String[] args) {
		ILispImpl impl = dispatcher.dispatch(args);
		return impl;
	}

}
