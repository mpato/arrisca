class BinarySearchTree {
 private :
  int key;
  BinarySearchTree *left, *right;
 public :
  BinarySearchTree();
  ~BinarySearchTree();
  void insert(int key, void *e);
  int remove(int key);
  void *get(int key);
};
