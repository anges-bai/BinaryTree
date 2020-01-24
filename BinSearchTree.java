import bittech.bin_tree.BinTree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
* @Description:二分搜索树
*/
public class BinSearchTree<E extends Comparable> implements BinTree<E> {
private class Node {
private E data;⽐特科技制作
private Node left;
private Node right;
public Node(E data) {
this.data = data;
 }
 }
private Node root;
private int size;
@Override
public void add(E e) {
if (root == null) {
Node node = new Node(e);
root = node;
size ++;
 }

add(root,e);
 }

private void add(Node root,E e) {

if (e.equals(root.data)) {
return;
 }else if (e.compareTo(root.data) < 0 && root.left == null) {
Node node = new Node(e);
root.left = node;
size ++;
 }else if (e.compareTo(root.data) > 0 && root.right == null) {
Node node = new Node(e);
root.right = node;
size ++;
 }

if (e.compareTo(root.data) < 0) {
add(root.left,e);
 }

if (e.compareTo(root.data) > 0) {
add(root.right,e);
 }
 }
@Override
public int getSize() {
return size;
 }
@Override
public boolean contains(E e) {
return contains(root,e);
 }

private boolean contains(Node root,E e) {

if (root == null) {
return false;
 }
if (e.equals(root.data)) {
return true;
 }

else if (e.compareTo(root.data) < 0) {
return contains(root.left,e);
 }

else {
return contains(root.right,e);
 }
 }
@Override
public void preOrder() {
preOrder(root);
 }

private void preOrder(Node node) {

if (node == null) {
return;
 }

System.out.println(node.data);
preOrder(node.left);
⽐特科技制作
preOrder(node.right);
 }

public void preOrderNR() {
Stack<Node> stack = new Stack<>();
stack.push(root);
while (!stack.isEmpty()) {
Node node = stack.pop();
System.out.println(node.data);
if (node.right != null)
stack.push(node.right);
if (node.left != null)
stack.push(node.left);
 }
 }
@Override
public void inOrder() {
inOrder(root);
 }
private void inOrder(Node node) {
if (node == null) {
return;
 }
inOrder(node.left);
System.out.println(node.data);
inOrder(node.right);
 }
@Override
public void postOrder() {
postOrder(root);
 }
private void postOrder(Node node) {
if (node == null) {
return;
 }
postOrder(node.left);
postOrder(node.right);
System.out.println(node.data);
 }

