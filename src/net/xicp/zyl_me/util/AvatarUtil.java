package net.xicp.zyl_me.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

public class AvatarUtil {
	public static ArrayList<String> avatars = new ArrayList<String>();
	private static Random ran = new Random();

	public static String getRandomAvatar() {
		readAvatars();
		int ranInt = ran.nextInt(avatars.size());
		return avatars.get(ranInt);
	}

	private static void readAvatars() {
		if (avatars == null || avatars.size() != 0) {
			return;
		}
		String path = ServletActionContext.getServletContext().getRealPath("avatar/");
		File f_path = new File(path);
		for (File file : f_path.listFiles()) {
			if (file.isFile())
				avatars.add("avatar/" + file.getName());
		}
	}
}
