package org.sky.sys.utils;

public class NumberUtils {
	public static String[] chineseDigits1 = new String[] { "零", "壹", "贰", "叁",
			"肆", "伍", "陆", "柒", "捌", "玖" };
	public static String[] chineseDigits2 = new String[] { "〇", "一", "二", "三",
			"四", "五", "六", "七", "八", "九" };

	public static String numToUpper1(int num) {
		String rstr = amountToChinese(num, chineseDigits1);
		return rstr;
	}

	public static String numToUpper2(int num) {
		String rstr = amountToChinese(num, chineseDigits2);
		return rstr;
	}

	/**
	 * 把金额转换为汉字表示的数量，小数点后四舍五入保留两位
	 * 
	 * @param amount
	 * @return
	 */
	public static String amountToChinese(int amount, String[] cin) {
		if (amount > 99999999999999.99 || amount < -99999999999999.99)
			throw new IllegalArgumentException(
					"参数值超出允许范围 (-99999999999999.99 ～ 99999999999999.99)！");

		boolean negative = false;
		if (amount < 0) {
			negative = true;
			amount = amount * (-1);
		}

		long temp = Math.round(amount * 100);
		int numFen = (int) (temp % 10); // 分
		temp = temp / 10;
		int numJiao = (int) (temp % 10); // 角
		temp = temp / 10;
		// temp 目前是金额的整数部分

		int[] parts = new int[20]; // 其中的元素是把原来金额整数部分分割为值在 0~9999 之间的数的各个部分
		int numParts = 0; // 记录把原来金额整数部分分割为了几个部分（每部分都在 0~9999 之间）
		for (int i = 0;; i++) {
			if (temp == 0)
				break;
			int part = (int) (temp % 10000);
			parts[i] = part;
			numParts++;
			temp = temp / 10000;
		}

		boolean beforeWanIsZero = true; // 标志“万”下面一级是不是 0

		String chineseStr = "";
		for (int i = 0; i < numParts; i++) {

			String partChinese = partTranslate(parts[i], cin);
			if (i % 2 == 0) {
				if ("".equals(partChinese))
					beforeWanIsZero = true;
				else
					beforeWanIsZero = false;
			}

			if (i != 0) {
				if (i % 2 == 0)
					chineseStr = "亿" + chineseStr;
				else {
					if ("".equals(partChinese) && !beforeWanIsZero) // 如果“万”对应的
																	// part 为
																	// 0，而“万”下面一级不为
																	// 0，则不加“万”，而加“零”
						chineseStr = "零" + chineseStr;
					else {
						if (parts[i - 1] < 1000 && parts[i - 1] > 0) // 如果"万"的部分不为
																		// 0,
																		// 而"万"前面的部分小于
																		// 1000
																		// 大于 0，
																		// 则万后面应该跟“零”
							chineseStr = "零" + chineseStr;
						chineseStr = "万" + chineseStr;
					}
				}
			}
			chineseStr = partChinese + chineseStr;
		}

		if ("".equals(chineseStr)) // 整数部分为 0, 则表达为"零元"
			chineseStr = cin[0];
		else if (negative) // 整数部分不为 0, 并且原金额为负数
			chineseStr = "负" + chineseStr;

		chineseStr = chineseStr + "";

		if (numFen == 0 && numJiao == 0) {
			chineseStr = chineseStr + "";
		} else if (numFen == 0) { // 0 分，角数不为 0
			chineseStr = chineseStr + "点" + cin[numJiao] + "";
		} else { // “分”数不为 0
			if (numJiao == 0) {
				chineseStr = chineseStr + "点零" + cin[numFen] + "";
			} else {// 角不为0
				chineseStr = chineseStr + "点" + cin[numJiao] + "" + cin[numFen]
						+ "";
			}
		}

		return chineseStr;

	}

	/**
	 * 把一个 0~9999 之间的整数转换为汉字的字符串，如果是 0 则返回 ""
	 * 
	 * @param amountPart
	 * @return
	 */
	private static String partTranslate(int amountPart, String[] cin) {
		if (amountPart < 0 || amountPart > 10000) {
			throw new IllegalArgumentException("参数必须是大于等于 0，小于 10000 的整数！");
		}

		String[] units = new String[] { "", "拾", "佰", "仟" };

		int temp = amountPart;

		String amountStr = new Integer(amountPart).toString();
		int amountStrLength = amountStr.length();
		boolean lastIsZero = true; // 在从低位往高位循环时，记录上一位数字是不是 0
		String chineseStr = "";

		for (int i = 0; i < amountStrLength; i++) {
			if (temp == 0) // 高位已无数据
				break;
			int digit = temp % 10;
			if (digit == 0) { // 取到的数字为 0
				if (!lastIsZero) // 前一个数字不是 0，则在当前汉字串前加“零”字;
					chineseStr = "零" + chineseStr;
				lastIsZero = true;
			} else { // 取到的数字不是 0
				chineseStr = cin[digit] + units[i] + chineseStr;
				lastIsZero = false;
			}
			temp = temp / 10;
		}
		return chineseStr;
	}
}
