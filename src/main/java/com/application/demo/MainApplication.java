package com.application.demo;

import com.application.demo.core.Tamagochi;
import com.application.demo.core.TamagochiGraveyard;
import com.application.demo.core.event.EventPublisher;
import com.application.demo.view.RandomGuiFrame;
import com.application.demo.view.RandomGuiTamagochi;

public class MainApplication {

	public static void main(String[] args) {
		EventPublisher ep = new EventPublisher();
		RandomGuiFrame rgf = new RandomGuiFrame();
		TamagochiGraveyard tg = new TamagochiGraveyard(ep);
		ep.addListener(rgf);
		tg.add("Laci");
		tg.add("Feri");
		for(int i = 0; i < 200; i++) {
			tg.update();
		}
	}
}
