package simon;

public class MoveCoby implements MoveInterfaceCoby{

	ButtonInterfaceCoby button;
	
	@Override
	public ButtonInterfaceCoby getTheButton() {
		return button;
	}
	
	public MoveCoby(ButtonInterfaceCoby button) {
		this.button = button;
	}
	

}
