/**
* 基于队列二分搜索树层序遍历1
*/
@Override
public void levelOrder() {
Queue<Node> queue = new LinkedList<>();
queue.add(root);
while (!queue.isEmpty()) {
Node node = queue.poll();
System.out.println(node.data);
if (node.left != null)
queue.add(node.left);
if (node.right != null)
queue.add(node.right);
 }
 }
@Override
public E getMin() {
if (size == 0) {
throw new IllegalArgumentException("BST is Empty!");
 }
return getMinNode(root).data;
 }
private Node getMinNode(Node node) {

if (node.left == null) {
return node;
 }

return getMinNode(node.left);
 }
@Override
public E getMax() {
if (size == 0) {
throw new IllegalArgumentException("BST is Empty!");
 }
return getMaxNode(root).data;
 }
private Node getMaxNode(Node node) {

if (node.right == null) {
return node;
 }

return getMinNode(node.right);
 }

@Override
public E removeMin() {
E result = getMin();
root = removeMinNode(root);
return result;
 }

private Node removeMinNode(Node node) {

if (node.left == null) {
Node rightTree = node.right;
node.right = null;
size --;
return rightTree;
 }
node.left = removeMinNode(node.left);
return node;
 }
@Override

public E removeMax(){
E ret = getMax();
root = removeMax(root);
return ret;
 }

private Node removeMax(Node node){
if(node.right == null){
Node leftNode = node.left;
node.left = null;
size --;
return leftNode;
 }
node.right = removeMax(node.right);
return node;
 }

public void removeNode(E e) {
root = removeNode(root,e);
 }

private Node removeNode(Node node,E e) {
if (node == null) {
return null;
 }

else if (e.compareTo(node.data) < 0) {
node.left = removeNode(node.left,e);
return node;
 }

else if (e.compareTo(node.data) > 0) {
node.right = removeNode(node.right,e);
return node;
 }

else {

if (node.left == null) {
Node rightTree = node.right;
node.right = null;
size --;
return rightTree;
 }

if (node.right == null) {
Node leftTree = node.left;
node.left = null;
size --;
return leftTree;
 }

// Hibbard Deletion
else {

Node successor = getMinNode(node.right);

successor.right = removeMinNode(node.right);

successor.left = node.left;
node.left = node.right = null;
return successor;
 }
 }
 }
 
@Override
public String toString() {
StringBuilder res = new StringBuilder();
generateBSTString(root,0,res);
return res.toString();
 }
private void generateBSTString(Node node,int depth,StringBuilder res) {
if (node == null) {
res.append(generateDepth(0)+"null\n");
return;
 }
res.append(generateDepth(depth)+node.data+"\n");
generateBSTString(node.left,depth+1,res);
generateBSTString(node.right,depth+1,res);
 }
private String generateDepth(int depth) {
StringBuilder sb = new StringBuilder();
for (int i = 0;i < depth;i++) {
sb.append("--");
 }
return sb.toString();
 }
}
