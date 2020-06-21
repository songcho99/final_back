package books.data;

import java.util.List;

public interface BooksServiceInter {

	public void insertBooks(BooksDto booksdto);
	public List<BooksDto> processBooks(int books_process_num);
}
