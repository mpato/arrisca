class BinarySearchTree {
 private :
  int key;
  void *e;
  BinarySearchTree *left, *right;
  BinarySearchTree* insert_node(BinarySearchTree *node, int key, void *e);
  void* get_node(BinarySearchTree *node, int key);
 public :
  BinarySearchTree();
  ~BinarySearchTree();
  void insert(int key, void *e);
  int remove(int key);
  void *get(int key);
};
