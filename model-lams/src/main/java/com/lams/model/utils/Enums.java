package com.lams.model.utils;

public class Enums {

	public enum Mode {
		ACTIVE(0, "Active"), INACTIVE(1, "InActive"), BOTH(-1, "Both");

		private Integer id;
		private String value;

		private Mode(Integer id, String value) {
			this.id = id;
			this.value = value;
		}

		public int getId() {
			return id;
		}

		public String getValue() {
			return value;
		}

		public static Mode getType(Integer x) {
			switch (x) {
			case 0:
				return ACTIVE;
			case 1:
				return INACTIVE;
			case -1:
				return BOTH;
			default:
				return null;
			}
		}

		public static Mode[] getAll() {
			return Mode.values();
		}
	}

	public enum UserType {
		ALL(-1, "All"), LENDER(1, "Lender"), BORROWER(2, "Borrower"), CHANNEL_PARTNER(3, "Channel Partner");

		private int id;
		private String value;

		private UserType(int id, String value) {
			this.id = id;
			this.value = value;
		}

		public int getId() {
			return id;
		}

		public String getValue() {
			return value;
		}

		public static UserType getType(Integer x) {
			switch (x) {
			case -1:
				return ALL;
			case 1:
				return LENDER;
			case 2:
				return BORROWER;
			case 3:
				return CHANNEL_PARTNER;
			default:
				return null;
			}
		}

		public static UserType[] getAll() {
			return UserType.values();
		}

	}

	public enum NotificationType {
		EMAIL(1, "Email"), SMS(2, "SMS"), SYSTEM(3, "SYSTEM");

		private int id;
		private String value;

		private NotificationType(int id, String value) {
			this.id = id;
			this.value = value;
		}

		public int getId() {
			return id;
		}

		public String getValue() {
			return value;
		}

		public static NotificationType getType(Integer x) {
			switch (x) {
			case 1:
				return EMAIL;
			case 2:
				return SMS;
			case 3:
				return SYSTEM;
			default:
				return null;
			}
		}

		public static NotificationType[] getAll() {
			return NotificationType.values();
		}
	}

	public enum ContentType {

		CONTENT, TEMPLATE

	}

	public enum AckType {

		NO_ACK, REQUIRED_ACK

	}

	public enum YesNoType {
		YES(1l, "Yes"), NO(2l, "No");

		private Long id;
		private String value;

		private YesNoType(Long id, String value) {
			this.id = id;
			this.value = value;
		}

		public Long getId() {
			return id;
		}

		public String getValue() {
			return value;
		}

		public static YesNoType getType(Long x) {
			switch (x.intValue()) {
			case 1:
				return YES;
			case 2:
				return NO;
			default:
				return null;
			}
		}

		public static YesNoType[] getAll() {
			return YesNoType.values();
		}
	}

	public enum OTPType {
		REGISTRATION(26l, "Registration", "RG");

		private Long id;
		private String value;
		private String code;

		private OTPType(Long id, String value, String code) {
			this.id = id;
			this.value = value;
		}

		public Long getId() {
			return id;
		}

		public String getValue() {
			return value;
		}

		public String getCode() {
			return code;
		}

		public static OTPType getType(String code) {
			switch (code) {
			case "RG":
				return REGISTRATION;
			default:
				return null;
			}
		}

		public static YesNoType[] getAll() {
			return YesNoType.values();
		}
	}
}
