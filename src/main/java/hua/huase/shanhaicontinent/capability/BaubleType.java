package hua.huase.shanhaicontinent.capability;

public enum BaubleType {
	HEAD(0),
	EXOSKELETON(1),
	LEFTHAND(2),
	RIGHTHAND(3),
	TRUNK(4),
	LEFTLEG(5),
	RIGHTLEG(6);

	int[] validSlots;

	private BaubleType(int ... validSlots) {
		this.validSlots = validSlots;
	}

	public boolean hasSlot(int slot) {
		for (int s:validSlots) {
			if (s == slot) return true;
		}
		return false; 
	}

	public int[] getValidSlots() {
		return validSlots;
	}
}
