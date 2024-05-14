//Evan Lyons
//4/15/24
//Binary search Tree - Arrrages nodes in a binary search tree, with nodes with lesser key to the left and greater key to the right.

public class BST{
	private Node root = null;
	
	public BST(){
	
	}
	
	public boolean isEmptyTree(){
		return root == null;	//will return true if root is null 
	}
	
	public Node search(int key){
		if(root.getKey()==key)	//if key is root - return root
			return root;
		else if(root==null)	//if tree is empty
			return null;
		else	//calls recursion 
			return(searchR(root, key));
		
		
	}
	
	public Node searchR(Node temp, int key){
		if(key==temp.getKey())	//if the key is the temp return temp
			return temp;
			
		else if(key<temp.getKey())	//if the key is less than temp go left
		
			return searchR(temp.getLeft(), key);
		else				//if the key is greater than temp go right
		
			return searchR(temp.getRight(), key);
	}
	
	public void insert(Node p){
		if(root == null)	//if tree is empty
			root = p;	
			
		else			//else call recursion
			insertR(root, p);
			
	}
	
	public void insertR(Node temp, Node p){
		//Node temp = root;
		if(p.getKey()<temp.getKey()){		//if p is less then temp - go to left
			if(temp.getLeft()==null){ 	//space is empty set left
				temp.setLeft(p);
			}
			else{		//else continue left by putting temp.left back into recursive function 
				insertR(temp.getLeft(), p);
			}
		}
		else{					//Same as above with right
			if(temp.getRight()==null){
				temp.setRight(p);
			}
			else{
				insertR(temp.getRight(),p);
			}
		}
	}
	
	public void traverse(){
		traverser(root);	//call traverse recursive function with root as input 
	}
	
	public void traverser(Node t){
		if(t!=null){	//when input is not null call both sides recusively and print key 
			traverser(t.getLeft());
			System.out.print(t.getKey()+" ");
			traverser(t.getRight());
		}
		//System.out.println();
	}
	
	public void delete(Node p){
		if(root!=null){
			if(p==root){	//if p is root 
				root=deleteRoot(p);
				
			}
			else{		//calls recursive function 
				deleteR(root, p);
			}			
		}
	}
	
	public void deleteR(Node temp, Node p){	//<<recussive function
		//finds the node to delete in the tree
		if(temp.getLeft()!=null && p.getKey() < temp.getKey()){	//if the pointer is less than temp 
			if(p.getKey()==temp.getLeft().getKey()){	//if p is equal to left 
				temp.setLeft(deleteRoot(p));		//calls delete root 
			}
			else{
				deleteR(temp.getLeft(),p);		//calls recursive but left node as new temp
			}
		}
		else if(temp.getRight()!=null && p.getKey() > temp.getKey()){ //same as above but for right
			if(p.getKey()==temp.getRight().getKey()){
				temp.setRight(deleteRoot(p));
			}
			else{
				deleteR(temp.getRight(),p);
			}
		}
		
		
	}
	
	private Node deleteRoot(Node P){
		if(P.getLeft()==null&&P.getRight()==null){//if p has no child nodes
			return null;
		}
		else if(P.getRight()==null && P.getLeft()!=null){//has one child node to the left
			Node temp = P;
			P = P.getLeft();
			P.setLeft(null);
			return P;
		}
		else if(P.getLeft()==null && P.getRight()!=null){//has one child node to the right
			Node temp = P;
			P = P.getRight();
			P.setRight(null);
			return P;
		}
		else{	//2 child nodes
			Node rootSucessor=getSucessor(P);	//sets sucessor to "rootSucessor"
			delete(rootSucessor);			//deletes the sucessor from tree
			Node tempL=P.getLeft();			//sets the left side to a new node
			Node tempR=P.getRight();		//right side
			rootSucessor.setLeft(tempL);		//attaches the side to "rootSucessor"
			rootSucessor.setRight(tempR);		
			P.setLeft(null);	
			P.setRight(null);
			return rootSucessor;
			
			
		}
	}
	
	public Node getSucessor(Node root){	//finds the sucessor 
		Node temp = root.getRight();
		while(temp.getLeft()!=null){
			temp=temp.getLeft();
		}
		return temp;
			
	}
	
   	public void printTree() {	//Print function 
   	System.out.println();
	printTree2(root);
	System.out.println();
    }

    private void printTree2(Node tree) {
	if (tree != null) {
	    System.out.print(tree.getKey() + " ");
            if (tree.getLeft() != null)
	        System.out.print("Left: " + tree.getLeft().getKey() + " ");
            else
                System.out.print("Left: null ");
            if (tree.getRight() != null)
	        System.out.println("Right: " + tree.getRight().getKey() + " ");
            else
                System.out.println("Right: null ");
	    printTree2(tree.getLeft());
	    printTree2(tree.getRight());
	}
    }

	

}
