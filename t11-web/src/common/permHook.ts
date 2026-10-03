import {decrypt} from "@/framework/crypto";
import {toLogin} from "@/common/LoginHook";
import router from "@/common/router";

let sessionUserPermArrValue: any[] = []
function getUserPermArr(){
    if(sessionUserPermArrValue.length == 0){
        const authorityArrStr: string = sessionStorage.getItem('authorityArrStr') as string
        if(null == authorityArrStr || '' == authorityArrStr){
            toLogin()
            return sessionUserPermArrValue
        }
        const authorityArr = decrypt(authorityArrStr)
        sessionUserPermArrValue = JSON.parse(authorityArr)
    }
    return sessionUserPermArrValue
}

// function hasPerm(permStr: any){
//     console.log('qqq')
//     const userPermArrValue: any[] = userPermArr.value
//     if(userPermArrValue.includes('superAdmin'))return
//     const permArray = getIntersectionPermArr(permStr)
//     return permArray.length > 0
// }
const  hasPerm = (permStr: any)=>{
    const userPermArrValue: any[] = getUserPermArr()
    if(userPermArrValue.includes('superAdmin'))return
    const permArray = getIntersectionPermArr(permStr)
    // console.log('permArray.length > 0:', permArray.length > 0)
    return permArray.length > 0
}
function getIntersectionPermArr(permStr: any){
    const userPermArrValue: any[] = getUserPermArr()
    const needPermArray: Array<string> = permStr.split(',')
    const permArray = needPermArray.filter(item => {
        if(userPermArrValue.includes(item)){
            return item
        }
    })
    return permArray
}
function getMenuTree(nodeArr: any[]){
    removeNoPermNode(nodeArr)
}
function removeNoPermNode(nodeArr: any[]){
    console.log(nodeArr.length);
    const userPermArrValue: any[] = getUserPermArr()
    if(userPermArrValue.includes('superAdmin'))return
    for(let i=0; i<nodeArr.length;i++){
        const node = nodeArr[i]
        if(isLeaf(node)){
            if(node.perm != undefined){
                const permStr = node.perm
                const permArray = getIntersectionPermArr(permStr)
                if(permArray.length == 0){
                    //remove
                    nodeArr.splice(i,1)
                    i --
                }
            }
        }else{
            removeNoPermNode(node.children)
            //remove branch if it has no child after remove child
            if(node.children.length == 0){
                nodeArr.splice(i,1)
                i --
            }
        }
    }
    console.log(nodeArr.length);
}
function isLeaf(node: any): boolean{
    return node.children == undefined
}
export function usePerm(){
    return { getMenuTree, hasPerm }
}
