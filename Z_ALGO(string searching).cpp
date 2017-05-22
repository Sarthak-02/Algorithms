#include <iostream>
#include <vector>
using namespace std;
z-algo------------------------
vector<int> z_algo_array(string t){
    int left=0;
    int right=0;
    vector<int> F(int(t.length()));
   
    for(int k=1;k<t.length();k++)
    {
      if(k>right){
          
        left=k;
        right=k;
        
        while(right<t.length()&&t[right]==t[right-left])
        {
            right++;
        }
        F[k]=right-left;
        right--;
      }
    else{
        int k1=k-left;
        if(F[k1]<right-k+1)
        {
            F[k]=F[k1];
        }
        else{
            left=k;
             while(right<t.length()&&t[right]==t[right-left])
            {
                right++;
            }
            F[k]=right-left;
            right--;
            
        }
        }}
    return F;
    
}
z-algo------------------------
int main()
{
    
    
    string s,p;
    cin>>p;
    cin>>s;
    int s1=s.length();
    int p1=p.length();
    
    int n=s1+p1+1;
    string t;
    t=p+'#'+s;
    vector<int> ans=z_algo_array(t);
    int count=0;
    for(int i=0;i<t.size();i++)
    {
        if(ans[i]==p1)
        {
         count++;   
        }
       // cout<<ans[i];
    }
    cout<<count<<endl;
    
    return 0;
}
