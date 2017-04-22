#include<iostream>
#include<list>
#define INFINITY 10000000
using namespace std;


class Graph{
public:
    int node;
    list<pair<int ,int> > *adj;


    Graph(int node){
        this->node=node;
        adj = new list<pair<int ,int> >[node];


    }
void addEdge(int v,int w,int d)
{
    adj[v].push_back(make_pair(w,d));
}
void BFS_01(int s){

list<int> dque;
dque.push_back(s);
int dist[node];
    for(int i=0;i<node;i++)
    {
        dist[i]=INFINITY;

    }
dist[s]=0;
while(!dque.empty()){



    int v=dque.front();
    dque.pop_front();
    list<pair<int ,int> >::iterator i;

    for(i=adj[v].begin();i!=adj[v].end();i++){

    //scout<<i->first<<"--"<<i->second<<endl;
    if(dist[i->first]>dist[v]+i->second)
    {
        dist[i->first]=dist[v]+i->second;

        if(i->second==0)
        {
            dque.push_front(i->first);
        }
        else{

            dque.push_back(i->first);
        }
    }
    }
}
for(int i=0;i<node;i++)
{
    cout<<dist[i]<<endl;
}

}

};
int main(){
Graph g(5);
    g.addEdge(0, 1, 1);
    g.addEdge(0, 2, 1);
    g.addEdge(0, 3, 0);
    g.addEdge(1, 4, 1);
    g.addEdge(3, 4, 1);
    g.addEdge(2, 3, 0);

    //source is 0
    g.BFS_01(0);

return 0;
}
