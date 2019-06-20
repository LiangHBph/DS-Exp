package Practice5_3_3;

/**
 * ��8�� �����������ࡣ
 */

import ch05.BiTreeNode;  //�������Ķ�����������

public class BSTree { //������������

    protected BiTreeNode root;   //�����

    public BSTree() {  //����ն���������
        root = null;
    }

    public BiTreeNode getRoot() {
        return root;
    }

    public void setRoot(BiTreeNode root) {
        this.root = root;
    }

    
    public boolean isEmpty() { //�ж��Ƿ�ն�����
        return this.root == null;
    }

    public void inOrderTraverse(BiTreeNode p) { //�и����������p���Ϊ���Ķ�����
        if (p != null) {
            inOrderTraverse(p.getLchild());
            System.out.print(((RecordNode) p.getData()).getKey() + "  ");
            inOrderTraverse(p.getRchild());
        }
    }

    //���ҹؼ���ֵΪkey�Ľ��,�����ҳɹ����ؽ��ֵ�����򷵻�null
    public Object searchBST(Comparable key) {
        if (key == null || !(key instanceof Comparable)) {
            return null;
        }
        return searchBST(root, key);
    }

    //�������������ҵĵݹ��㷨
    //�ڶ����������в��ҹؼ���Ϊkey�Ľ�㡣�����ҳɹ��򷵻ؽ��ֵ�����򷵻�null
    private Object searchBST(BiTreeNode p, Comparable key) {
        if (p != null) {
            if (key.compareTo(((RecordNode) p.getData()).getKey()) == 0) //���ҳɹ�
            {
                return p.getData();
            }
            //     System.out.print(((RecordNode) p.getData()).getKey() + "? ");
            if (key.compareTo(((RecordNode) p.getData()).getKey()) < 0) {
                return searchBST(p.getLchild(), key);     //���������в���
            } else {
                return searchBST(p.getRchild(), key);    //���������в���
            }
        }else {
            System.out.print("����ʧ�ܣ�");			
        	return null;
		}
    }

    //�ڶ����������в���ؼ���ΪKey,������ΪtheElement�Ľ��,������ɹ�����true,���򷵻�false
    public boolean insertBST(Comparable key, Object theElement) {
        if (key == null || !(key instanceof Comparable)) {//���ܲ���ն���򲻿ɱȽϴ�С�Ķ���
            return false;
        }
        if (root == null) {
            root = new BiTreeNode(new RecordNode(key, theElement)); //���������
            return true;
        }
        return insertBST(root, key, theElement);
    }

    //���ؼ���Ϊkey,������ΪtheElement�Ľ����뵽��pΪ���Ķ����������еĵݹ��㷨
    private boolean insertBST(BiTreeNode p, Comparable key, Object theElement) {
        if (key.compareTo(((RecordNode) p.getData()).getKey()) == 0) {
            return false;             //������ؼ����ظ��Ľ��
        }
        if (key.compareTo(((RecordNode) p.getData()).getKey()) < 0) {
            if (p.getLchild() == null) {        //��p��������Ϊ��
                p.setLchild(new BiTreeNode(new RecordNode(key, theElement)));  //����Ҷ�ӽ����Ϊp������
                return true;
            } else {                      //��p���������ǿ�
                return insertBST(p.getLchild(), key, theElement);   //���뵽p����������
            }
        } else if (p.getRchild() == null) {    //��p��������Ϊ��
            p.setRchild(new BiTreeNode(new RecordNode(key, theElement)));    //����Ҷ�ӽ����Ϊp���Һ���
            return true;
        } else {                          //��p���������ǿ�
            return insertBST(p.getRchild(), key, theElement);   //���뵽p����������
        }
    }

    //������������ɾ������㷨����ɾ���ɹ�����ɾ�����ֵ�����򷵻�null
    public Object removeBST(Comparable key) {
        if (root == null || key == null || !(key instanceof Comparable)) {
            return null;
        }
        //����rootΪ���Ķ�����������ɾ���ؼ���ΪelemKey�Ľ��
        return removeBST(root, key, null);
    }

    //����pΪ���Ķ�����������ɾ���ؼ���ΪelemKey�Ľ�㡣parent��p�ĸ���㣬�ݹ��㷨
    private Object removeBST(BiTreeNode p, Comparable elemKey, BiTreeNode parent) {
        if (p != null) {
            if (elemKey.compareTo(((RecordNode) p.getData()).getKey()) < 0) { //����������ɾ��
                return removeBST(p.getLchild(), elemKey, p);    //���������еݹ�����
            } else if (elemKey.compareTo(((RecordNode) p.getData()).getKey()) > 0) { //����������ɾ��
                return removeBST(p.getRchild(), elemKey, p);    //���������еݹ�����
            } else if (p.getLchild() != null && p.getRchild() != null) {
                //����Ҹý������������
                BiTreeNode innext = p.getRchild();    //Ѱ��p���и������µĺ�̽��innext
                while (innext.getLchild() != null) { //��Ѱ���������е�������
                    innext = innext.getLchild();
                }
                p.setData(innext.getData());              //�Ժ�̽��ֵ�滻p
                return removeBST(p.getRchild(), ((RecordNode) p.getData()).getKey(), p); //�ݹ�ɾ�����p
            } else {//p��1�Ⱥ�Ҷ�ӽ��
                if (parent == null) {  //ɾ������㣬��p==root
                    if (p.getLchild() != null) {
                        root = p.getLchild();
                    } else {
                        root = p.getRchild();
                    }
                    return p.getData();       //����ɾ�����pֵ
                }
                if (p == parent.getLchild()) { //p��parent������
                    if (p.getLchild() != null) {
                        parent.setLchild(p.getLchild());  //��p���������
                    } else {
                        parent.setLchild(p.getRchild());
                    }
                } else if (p.getLchild() != null) { //p��parent���Һ�����p���������ǿ�
                    parent.setRchild(p.getLchild());
                } else {
                    parent.setRchild(p.getRchild());
                }
                
                System.out.print("ɾ���ɹ���"); 			
                return p.getData();
            }
        }else {
            System.out.print("ɾ��ʧ�ܣ�"); 			
        	return null;
		}
    }
}
