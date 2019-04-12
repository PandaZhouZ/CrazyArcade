package com.a225.thread;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.a225.model.manager.ElementManager;
import com.a225.model.vo.SuperElement;

/**
 * ��Ϸ�߳̿���
 * @author ���
 *
 */
public class GameThread extends Thread{
	public void run() {
		while(true) {
			//���ص�ͼ
			loadElement();
			//��ʾ������̣��Զ���
			runGame();
			//��������ͼ
		}
		
	}
	
	//���ص�ͼ
	private void loadElement() {
		ElementManager.getManager().loadElement();
	}
	
	//��ʾ�����Ϸ���̣��Զ���
	private void runGame() {
		while(true) {
			Map<String, List<SuperElement>> map = ElementManager.getManager().getMap();
			Set<String> set = map.keySet();
			for(String key:set) {
				List<SuperElement> list = map.get(key);
				
				for(int i=list.size()-1; i>=0; i--) {
					list.get(i).update();
					if(!list.get(i).isAlive())
						list.remove(i);
				}
			}
			
			//������Ϸ�����̿���linkGame()?
			
			//����runGame����
			try {	
				sleep(50);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	//runGame���ã�������չ
	public void linkGame() {}
	
	//�ؿ�����
	private void overGame() {}

}