import type {AuthRoleParam, AuthRoleEntity, AuthRoleRelateList} from '@/business/auth/model/authRoleModel'
import { useAuthRoleModel } from '@/business/auth/model/authRoleModel'
const { createAuthRoleParam, createAuthRoleEntity } = useAuthRoleModel()
import type {AuthUserParam, AuthUserEntity, AuthUserRelateList} from '@/business/auth/model/authUserModel'
import { useAuthUserModel } from '@/business/auth/model/authUserModel'
const { createAuthUserParam, createAuthUserEntity } = useAuthUserModel()
interface AuthUserRoleRelParam {
    id: any
    userId: any
    roleId: any
    userParam: AuthUserParam
    roleParam: AuthRoleParam
}
interface AuthUserRoleRelEntity {
    id: any
    userId: any
    roleId: any
    isValid: any
    sortNum: any
    userEntity: AuthUserEntity
    roleEntity: AuthRoleEntity
}
interface AuthUserRoleRelRelateList {
    userEntityList:AuthUserEntity[]
    roleEntityList:AuthRoleEntity[]
}
function createAuthUserRoleRelParam(): AuthUserRoleRelParam{
    return {
       id: '',
       userId: '',
       roleId: '',
       userParam: createAuthUserParam(),
       roleParam: createAuthRoleParam(),
    }
}
function createAuthUserRoleRelEntity(): AuthUserRoleRelEntity{
    return {
       id: '',
       userId: '',
       roleId: '',
       isValid: '',
       sortNum: '',
       userEntity: createAuthUserEntity(),
       roleEntity: createAuthRoleEntity(),
    }
}
export function useAuthUserRoleRelModel(){
    return { createAuthUserRoleRelParam, createAuthUserRoleRelEntity,
     }
}
export type { AuthUserRoleRelParam, AuthUserRoleRelEntity, AuthUserRoleRelRelateList }


