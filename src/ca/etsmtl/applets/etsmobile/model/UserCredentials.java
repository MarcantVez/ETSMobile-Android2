package ca.etsmtl.applets.etsmobile.model;

import android.content.SharedPreferences;

/**
 * Created by Phil on 17/11/13.
 */
public class UserCredentials {
	public static final String CODE_U = "codeAccesUniversel";

	public static final String CODE_P = "motPasse";

	public static final String APPT = "appt";

	public static final String REZ = "rez";

	private String password = "";

	private String username = "";

	private String phase = "";

	private String appt = "";

	public UserCredentials(final SharedPreferences prefs) {
		if (prefs != null) {
			username = prefs.getString(UserCredentials.CODE_P, "");
			password = prefs.getString(UserCredentials.CODE_U, "");
			phase = prefs.getString(UserCredentials.REZ, "");
			appt = prefs.getString(UserCredentials.APPT, "");
		}
	}

	public UserCredentials(final String codeU, final String codeP) {
		username = codeU;
		password = codeP;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getPhase() {
		return phase;
	}

	public String getAppt() {
		return appt;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public void setPhase(String p) {
		phase = p;
	}

	public void setAppt(String appt) {
		this.appt = appt;
	}

	public boolean isEmployee() {
		return username.equals("empl") && password.equals("empl");
	}

	public boolean hasBandwithInfo() {
		return appt != null && phase != null;
	}

	public boolean isLoggedIn() {
		return !"".equals(password) && !"".equals(username);
	}

}
