package Hw6_22000070_NguyenThiAnh.BaiTap1;

public interface OrderedSymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {
    Key min();                  // Tìm khóa nhỏ nhất
    Key max();                  // Tìm khóa lớn nhất
    Key floor(Key key);         // Tìm khóa lớn nhất nhỏ hơn hoặc bằng khóa cho trước
    Key ceiling(Key key);       // Tìm khóa nhỏ nhất lớn hơn hoặc bằng khóa cho trước
    int rank(Key key);          // Xếp hạng của khóa cho trước
    Key select(int k);          // Chọn khóa xếp hạng k
    void deleteMin();           // Xóa khóa nhỏ nhất
    void deleteMax();           // Xóa khóa lớn nhất
    int size(Key u, Key v);     // Kích thước của bảng giữa hai khóa u và v
    Iterable<Key> keys(Key u, Key v); // Các khóa giữa hai khóa u và v
}

