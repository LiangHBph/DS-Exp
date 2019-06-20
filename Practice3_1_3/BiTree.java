package Practice3_1_3;

/**
 * 
 * ������ʽ�洢�ṹ�µĶ�����
 * 
 */

public class BiTree {

	private BiTreeNode root;// ���ĸ����

	public BiTree() {// ����һ�ÿ���
		this.root = null;
	}

	public BiTree(BiTreeNode root) {// ����һ����
		this.root = root;
	}

	// ���ȸ�������������и����������齨��һ�ö�����
	// ���в���preOrder���������� �ȸ�������inOrder�����������и�������preIndex��
	// �ȸ�������preOrder�ַ����еĿ�ʼλ�ã�inIndex���и��������ַ���inOrder�еĿ�ʼλ�ã�count��ʾ�����ĸ���
	/*
	 * public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int
	 * count) { if (count > 0) {// �ȸ����и��ǿ� char r = preOrder.charAt(preIndex);//
	 * ȡ�ȸ��ַ����еĵ�һ��Ԫ����Ϊ����� int i = 0; for (; i < count; i++) // Ѱ�Ҹ�������и������ַ����е����� if
	 * (r == inOrder.charAt(i + inIndex)) break;
	 * 
	 * root = new BiTreeNode(r);// �������ĸ���� root.setLchild(new BiTree(preOrder,
	 * inOrder, preIndex + 1, inIndex, i).root);// �������������� root.setRchild(new
	 * BiTree(preOrder, inOrder, preIndex + i + 1, inIndex + i + 1, count - i -
	 * 1).root);// �������������� } }
	 */

	// �ɱ������������ȸ��������н���һ�ö�����
	private static int index = 0;// ���ڼ�¼preStr������ֵ

	public BiTree(String preStr) {
		char c = preStr.charAt(index++);// ȡ���ַ�������Ϊindex���ַ�����index��1
		if (c != '#') {// �ַ���Ϊ#
			root = new BiTreeNode(c);// �������ĸ����
			root.setLchild(new BiTree(preStr).root);// ��������������
			root.setRchild(new BiTree(preStr).root);// ��������������
		} else
			root = null;
	}

	// �ȸ��������������������ĵݹ��㷨
	public void preRootTraverse(BiTreeNode T) {
		if (T != null) {
			System.out.print(T.getData()); // ���ʸ����
			preRootTraverse(T.getLchild());// ����������
			preRootTraverse(T.getRchild());// ����������
		}
	}

	// �ȸ��������������������ķǵݹ��㷨
	public void preRootTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// ����ջ
			S.push(T);// �������ջ
			while (!S.isEmpty()) {
				T = (BiTreeNode) S.pop();// �Ƴ�ջ����㣬��������ֵ
				System.out.print(T.getData()); // ���ʽ��
				while (T != null) {
					if (T.getLchild() != null) // ��������
						System.out.print(T.getLchild().getData()); // ���ʽ��

					if (T.getRchild() != null)// �Һ��ӷǿ���ջ
						S.push(T.getRchild());

					T = T.getLchild();
				}
			}
		}
	}

	// �и��������������������ĵݹ��㷨
	public void inRootTraverse(BiTreeNode T) {
		if (T != null) {
			inRootTraverse(T.getLchild());// ����������
			System.out.print(T.getData()); // ���ʸ����
			inRootTraverse(T.getRchild());// ����������
		}
	}
//������и�����  �����ṩ�ȸ������޸�  �Ķ�֮��������ע��
	public BiTree(String postOrder, String inOrder, int postIndex, int inIndex, int count) {
		if (count > 0) {
			char r = postOrder.charAt(postIndex);
			int i = 0;
			for (; i < count; i++)
				if (r == inOrder.charAt(inIndex - i))//�иĶ�
					break;
			root = new BiTreeNode(r);
			root.setRchild(new BiTree(postOrder, inOrder, postIndex - 1, inIndex, i).root);// �����������������и�
			root.setLchild(new BiTree(postOrder, inOrder, postIndex - i - 1, inIndex - i - 1, count - i - 1).root);// ��������������
		}
	}

	// �и��������������������ķǵݹ��㷨
	public void inRootTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// ������ջ
			S.push(T); // �������ջ
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// ��ջ�������������ӽ����ջ
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // �ս����ջ
				if (!S.isEmpty()) {
					T = (BiTreeNode) S.pop();// �Ƴ�ջ����㣬��������ֵ
					System.out.print(T.getData()); // ���ʽ��
					S.push(T.getRchild());// �����Һ�����ջ
				}
			}
		}
	}

	// ����������������������ĵݹ��㷨
	public void postRootTraverse(BiTreeNode T) {
		if (T != null) {
			postRootTraverse(T.getLchild());// ����������
			postRootTraverse(T.getRchild());// ����������
			System.out.print(T.getData()); // ���ʸ����
		}
	}

	// ����������������������ķǵݹ��㷨
	public void postRootTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkStack S = new LinkStack();// ������ջ
			S.push(T); // ������ջ
			Boolean flag;// ���ʱ��
			BiTreeNode p = null;// pָ��ձ����ʵĽ��
			while (!S.isEmpty()) {
				while (S.peek() != null)
					// ��ջ�������������ӽ����ջ
					S.push(((BiTreeNode) S.peek()).getLchild());
				S.pop(); // �ս����ջ
				while (!S.isEmpty()) {
					T = (BiTreeNode) S.peek();// �鿴ջ��Ԫ��
					if (T.getRchild() == null || T.getRchild() == p) {
						System.out.print(T.getData()); // ���ʽ��
						S.pop();// �Ƴ�ջ��Ԫ��
						p = T;// pָ��ձ����ʵĽ��
						flag = true;// ���÷��ʱ��
					} else {
						S.push(T.getRchild());// �Һ��ӽ����ջ
						flag = false;// ����δ�����ʱ��
					}
					if (!flag)
						break;
				}
			}
		}
	}

	// ��α��������������������㷨(��������)
	public void levelTraverse() {
		BiTreeNode T = root;
		if (T != null) {
			LinkQueue L = new LinkQueue();// �������
			L.offer(T);// ����������
			while (!L.isEmpty()) {
				T = (BiTreeNode) L.poll();
				System.out.print(T.getData()); // ���ʽ��
				if (T.getLchild() != null)// ���ӷǿգ������
					L.offer(T.getLchild());
				if (T.getRchild() != null)// �Һ��ӷǿգ������
					L.offer(T.getRchild());
			}
		}

	}

	public BiTreeNode getRoot() {
		return root;
	}

	public void setRoot(BiTreeNode root) {
		this.root = root;
	}

	// ͳ��Ҷ�����Ŀ
	public int countLeafNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			if (T.getLchild() == null && T.getRchild() == null) {
				++count;// Ҷ�������1
			} else {
				count += countLeafNode(T.getLchild()); // ������������Ҷ�����
				count += countLeafNode(T.getRchild());// �����������ϵ�Ҷ�����
			}
		}
		return count;
	}

	// ͳ�ƽ�����Ŀ
	public int countNode(BiTreeNode T) {
		int count = 0;
		if (T != null) {
			++count;// �������1
			count += countNode(T.getLchild()); // �����������Ͻ����
			count += countNode(T.getRchild());// �����������ϵĽ����
		}
		return count;
	}

}
