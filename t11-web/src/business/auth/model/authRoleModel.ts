
interface AuthRoleParam {
    id: any
    code: any
}
interface AuthRoleEntity {
    id: any
    code: any
    name: any
    isValid: any
    sortNum: any
}
interface AuthRoleRelateList {
}
function createAuthRoleParam(): AuthRoleParam{
    return {
        id: '',
        code: '',
    }
}
function createAuthRoleEntity(): AuthRoleEntity{
    return {
        id: '',
        code: '',
        name: '',
        isValid: '',
        sortNum: '',
    }
}
export function useAuthRoleModel(){
    return { createAuthRoleParam, createAuthRoleEntity,
    }
}
export type { AuthRoleParam, AuthRoleEntity, AuthRoleRelateList }


