package woo.siksin.hander;

public class SiksinHandlerAdapter {
	private boolean redirect = false;
	private String path = null;

	public boolean isRedirect() {
		System.out.println("핸들러어댑터: isRedirect ");
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		System.out.println("핸들러어댑터: setRedirect");
		this.redirect = redirect;
	}

	public String getPath() {
		System.out.println("핸들러어댑터: getPath");
		return path;
	}

	public void setPath(String path) {
		System.out.println("핸들러어댑터: setPath");
		this.path = path;
	}

}
