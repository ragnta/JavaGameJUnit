package com.application.demo.view;

import java.util.ArrayList;
import java.util.List;

import com.application.demo.core.Tamagochi;
import com.application.demo.core.event.Listener;

public class RandomGuiFrame implements Listener {

	private List<RandomGuiTamagochi> tamagochiViewList = new ArrayList<>();

	@Override
	public void removeByTamagochi(Tamagochi t) {
		tamagochiViewList.stream()
				.filter(tamagochiView -> tamagochiView.getTamagochi().equals(t)) // filter list by tamagochi
				.findFirst() // get the first element of the filtered list which should be removeable tamagochiview element
				.ifPresent(removeAble -> { // if the first element is not null we will remove it from the list
					tamagochiViewList.remove(removeAble);
					System.out.println(removeAble.getTamagochi().getName() + " is removed");
				});
		;

	}

	@Override
	public void addTamagochi(Tamagochi t) {
		RandomGuiTamagochi e = new RandomGuiTamagochi(t);
		tamagochiViewList.add(e);
		System.out.println(e.getTamagochi().getName() + " is added");
	}

}
