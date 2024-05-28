package com.edu.uco.pch.business.usecase;

public interface UseCaseWithRurn <T, R> {
	R execute (T data);

}
