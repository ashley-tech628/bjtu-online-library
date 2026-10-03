
interface AuthUserParam {
    id: any
    username: any
    realName: any
}
interface AuthUserEntity {
    id: any
    username: any
    password: any
    realName: any
    lastLoginTime: any
    avatarGroupId: any
    mobile: any
    remark: any
    isValid: any
    sortNum: any
}
interface AuthUserRelateList {
}
function createAuthUserParam(): AuthUserParam{
    return {
       id: '',
       username: '',
       realName: '',
    }
}
function createAuthUserEntity(): AuthUserEntity{
    return {
       id: '',
       username: '',
       password: '',
       realName: '',
       lastLoginTime: '',
       avatarGroupId: '',
       mobile: '',
       remark: '',
       isValid: '',
       sortNum: '',
    }
}
export function useAuthUserModel(){
    return { createAuthUserParam, createAuthUserEntity,
     }
}
export type { AuthUserParam, AuthUserEntity, AuthUserRelateList }


