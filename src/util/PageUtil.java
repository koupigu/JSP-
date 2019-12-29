package util;

public class PageUtil {

	/**
	 * 获取分页起始位置
	 * 
	 * @param page 页面数
	 * @return 分页起始位置
	 */
	public static int indexOfPage(String page) {
		int start = 1;
		if (page != null) {
			start = Integer.parseInt(page);
		}
		int begin = (start - 1) * 10;
		return begin;
	}

	/**
	 * 获取不同分类文章总数
	 * 
	 * @return 总页数
	 */
	public static long getKindOfCategorySize(long count) {
		final int size = 10;
		long totalPages = 1;
		if (count % size == 0 && count != 0) {
			totalPages = count / 10;
		}
		totalPages = count / 10 + 1;
		return totalPages;
	}
}
