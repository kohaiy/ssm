package cn.gqxqd.printer;

import cn.gqxqd.ink.Ink;
import cn.gqxqd.paper.Paper;

public class Printer {
	private Ink ink;
	private Paper paper;

	public void print(String content) {
		System.out.println("--START PRINTING--");
		System.out.println("��ʹ����" + ink.getInkColor() + "īˮ��"
				+ paper.getPaperType() + "ֽ�Ŵ�ӡ��[" + content + "]");
		System.out.println("--PRINTED--");
	}

	public Ink getInk() {
		return ink;
	}

	public void setInk(Ink ink) {
		this.ink = ink;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

}