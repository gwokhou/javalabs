package designpattern.iterator.demo;

import designpattern.iterator.Aggregate;
import designpattern.iterator.Iterator;

/**
 * @author Guo-hao Zhang
 */
public class BookShelf implements Aggregate {
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }

    private static class BookShelfIterator implements Iterator {
        private BookShelf bookShelf;
        private int index;

        BookShelfIterator(BookShelf bookShelf) {
            this.bookShelf = bookShelf;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < bookShelf.getLength();
        }

        @Override
        public Object next() {
            Book book = bookShelf.getBookAt(index);
            index++;
            return book;
        }
    }
}
