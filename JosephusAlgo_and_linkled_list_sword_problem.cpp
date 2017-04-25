#include<iostream>
using namespace std;

struct node{
int data;
node* next;
}*head;
int survivor(int n)
{

        node *temp=new node();
        node *head=new node();
        for(int i=1;i<=n;i++)
        {
            if(i==1)
            {
                head->data=1;
                temp=head;

            }

            else{
                node* t=new node();
                t->data=i;
                temp->next=t;
                temp=t;


            }

        }
        temp->next=NULL;


        temp=head;
        node* temp1=new node();
        node* temp2=new node();
        while(head->next!=NULL)
        {


            if(temp->next==NULL)
            {
            // cout<<temp->data<<"--1"<<endl;;
             head=head->next;
             temp=head;
            }
            else if(temp->next->next==NULL)
            {
                temp->next=NULL;
                temp=head;
               // cout<<temp->data<<" 2"<<endl;
            }
            else{
                temp1=temp->next->next;
            temp->next=temp1;
            temp=temp1;
            }
        }
return head->data;
    }




//Josephus ALGO
int josephus(int n,int k){
if(n==1)
    return 1;
else
    return (josephus(n-1,k)+k-1)%n+1;
}

int main(){
int n;
cout<<"Enter no of people"<<endl;
cin>>n;
int k;
cout<<"Enter the no of people to skip"<<endl;
cin>>k;
int ans=josephus(n,k);
cout<<"J----"<<ans<<"----J"<<endl;
if(k==2)
{
    cout<<"if no of people to skip is 2 than we can solve it with linked list"<<endl;
    ans=survivor(n);
    cout<<"L---"<<ans<<"---L"<<endl;
}




return 0;
}
