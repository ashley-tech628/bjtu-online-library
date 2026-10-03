import { usePerm } from '@/common/permHook'
const { getMenuTree } = usePerm()

/**
 * 移除无权限的leaf，移除无leaf的branch
 * @param nodeArr
 */

function initMenuData(initialClassName: string, menuArrRef: any){
  getMenuTree(menuArr)
  for (const item0 of menuArr) {
    for (const item0Child of item0.children) {
      const item1: any = item0Child
      if(item1.className == undefined || item1.className != initialClassName)
        item1.className = initialClassName
    }
  }
  console.log('mmm:', menuArr)
  menuArrRef.value = menuArr
}
const menuArr = [
 {
   title: "auth",
   icon: "el-icon-files",
   childrenDisplay:"block",
   children: [
     {
       perm: "authRole.read",
       title: "角色",
       path: "/mobile/authRole/pageAuthRole",
     },
     {
       perm: "authPerm.read",
       title: "权限",
       path: "/mobile/authPerm/pageAuthPerm",
     },
     {
       perm: "authRolePermRel.read",
       title: "角色权限关联",
       path: "/mobile/authRolePermRel/pageAuthRolePermRel",
     },
     {
       perm: "authUserRoleRel.read",
       title: "用户角色关联",
       path: "/mobile/authUserRoleRel/pageAuthUserRoleRel",
     },
     {
       perm: "authUser.read",
       title: "用户",
       path: "/mobile/authUser/pageAuthUser",
     },
   ],
 },
 {
   title: "house",
   icon: "el-icon-files",
   childrenDisplay:"block",
   children: [
     {
       perm: "houseRegion.read",
       title: "校区信息",
       path: "/mobile/houseRegion/pageHouseRegion",
     },
   ],
 },
 {
   title: "basic",
   icon: "el-icon-files",
   childrenDisplay:"block",
   children: [
     {
       perm: "basicFile.read",
       title: "文件",
       path: "/mobile/basicFile/pageBasicFile",
     },
   ],
 },
]
export function useMenuData(){
  return { initMenuData }
}
