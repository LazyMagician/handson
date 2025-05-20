package com.weathersystem.impls;

import java.util.concurrent.atomic.AtomicInteger;

import com.weathersystem.interfaces.ObserverModule;

public abstract class DisplayModule implements ObserverModule {

	private AtomicInteger counter = new AtomicInteger();

	private Integer id;

	public DisplayModule() {
		this.id = counter.incrementAndGet();
	}

	@Override
	public Integer getId() {
		return id;
	}

}
