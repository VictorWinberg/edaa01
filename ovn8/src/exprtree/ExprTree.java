package exprtree;

public class ExprTree {
	private ExprNode root;

	public ExprTree() {
		root = null;
	}

	/**
	 * Skapar ett bin√§rt tr√§d med inneh√•llet data i roten och med leftTree som
	 * v√§nster undertr√§d och rightTree som h√∂ger undertr√§d.
	 */
	public ExprTree(String element, ExprTree leftTree, ExprTree rightTree) {
		root = new ExprNode(element);
		if (leftTree != null) {
			root.left = leftTree.root;
		} else {
			root.left = null;
		}
		if (rightTree != null) {
			root.right = rightTree.root;
		} else {
			root.right = null;
		}
	}

	/**
	 * Returnerar en teckenstr‰ng som representerar uttrycket. Teckenstr‰ngen
	 * innehÂller parenteser runt alla deluttryck, utom runt talen.
	 */
	public String fullParen() {
		if (root == null) {
			return "";
		} else {
			StringBuilder sb = new StringBuilder();
			recFullParen(root, sb);
			return sb.toString();
		}
	}
	/*
	 * L‰gger i sb till de tecken som representerar uttrycket i det tr‰d d‰r n ‰r
	 * rot. Tecknen innehÂller parenteser runt alla deluttryck, utom runt talen.
	 */
	private void recFullParen(ExprNode n, StringBuilder sb) {
		if (n.left == null && n.right == null) {
			sb.append(n.element);
		} else {
			sb.append('('); // Tr‰det ‰r strikt bin‰rt, b‰gge subtr‰den icke-tomma
			recFullParen(n.left, sb);
			sb.append(n.element);
			recFullParen(n.right, sb);
			sb.append(')');
		}
	}

	private static class ExprNode {
		public ExprNode(String element) {
			this.element = element;
		}

		String element;
		ExprNode left;
		ExprNode right;
	}

	public static void main(String[] args) {
		ExprTree empty = new ExprTree();
		System.out.println(empty.fullParen());

		ExprTree leftOp = new ExprTree("9", null, null);
		ExprTree rightOp = new ExprTree("2", null, null);
		ExprTree minus = new ExprTree("-", leftOp, rightOp);

		leftOp = new ExprTree("5", null, null);
		ExprTree mult = new ExprTree("*", leftOp, minus);

		rightOp = new ExprTree("7", null, null);
		ExprTree tree = new ExprTree("+", mult, rightOp);
		System.out.println(tree.fullParen());
	}
}
