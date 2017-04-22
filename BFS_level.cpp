#include<iostream>
#include<list>

using namespace std;

class Graph{
public:
    int node;
    list<int> *adj;

Graph(int node)
{
    this->node=node;
    adj = new list<int>[node];
}
void addEdge(int node,int w)
{
    adj[node].push_back(w);
}
void BFS(int s)
{
    bool *visited = new bool[node];
    int *level = new int[node];
    for(int i=0;i<node;i++)
    {
        visited[i]=false;
    }

    list<int> q;
    q.push_back(s);
    visited[s]=true;
    level[s]=0;
    while(!q.empty())
    {
        s=q.front();

        cout<<s<<"-"<<level[s]<<endl;

        q.pop_front();

        list<int>::iterator i;
        for(i=adj[s].begin();i!=adj[s].end();i++)
        {
            if(!visited[*i])
            {
                level[*i]=level[s]+1;//level
                visited[*i]=true;
                q.push_back(*i);

            }
        }
    }

}
};
int main(){
Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    int t;
    cout<<"enter node between 0 and 4"<<endl;
    cin>>t;
    cout<<endl;
    if(t>=0&&t<4)
    g.BFS(t);
return 0;}
