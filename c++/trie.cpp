#include<iostream>
#define ALPHABET_SIZE 26
using namespace std;
struct trieNode {
    struct trieNode * children[ALPHABET_SIZE];
    bool isLeaf;
};
struct trieNode * getNode() {
    struct trieNode * node = (struct trieNode *)malloc(sizeof(struct trieNode));

    for (int i = 0;i<ALPHABET_SIZE;i++)
    {
        node->isLeaf = false;
        node->children[i] = NULL;
    }
    return node;
}
int main()
{
    cout<<"hellaGDgdklsgKHdjskghsdkghkdsGo";
    return 0;
}