import type {AuthRoleParam, AuthRoleEntity, AuthRoleRelateList} from '@/business/auth/model/authRoleModel'
import { useAuthRoleModel } from '@/business/auth/model/authRoleModel'
const { createAuthRoleParam, createAuthRoleEntity } = useAuthRoleModel()
import type {AuthPermParam, AuthPermEntity, AuthPermRelateList} from '@/business/auth/model/authPermModel'
import { useAuthPermModel } from '@/business/auth/model/authPermModel'
const { createAuthPermParam, createAuthPermEntity } = useAuthPermModel()
interface AuthRolePermRelParam {
    id: any
    roleId: any
    permId: any
    roleParam: AuthRoleParam
    permParam: AuthPermParam
}
interface AuthRolePermRelEntity {
    id: any
    roleId: any
    permId: any
    isValid: any
    sortNum: any
    roleEntity: AuthRoleEntity
    permEntity: AuthPermEntity
}
interface AuthRolePermRelRelateList {
    roleEntityList:AuthRoleEntity[]
    permEntityList:AuthPermEntity[]
}
function createAuthRolePermRelParam(): AuthRolePermRelParam{
    return {
       id: '',
       roleId: '',
       permId: '',
       roleParam: createAuthRoleParam(),
       permParam: createAuthPermParam(),
    }
}
function createAuthRolePermRelEntity(): AuthRolePermRelEntity{
    return {
       id: '',
       roleId: '',
       permId: '',
       isValid: '',
       sortNum: '',
       roleEntity: createAuthRoleEntity(),
       permEntity: createAuthPermEntity(),
    }
}
export function useAuthRolePermRelModel(){
    return { createAuthRolePermRelParam, createAuthRolePermRelEntity,
     }
}
export type { AuthRolePermRelParam, AuthRolePermRelEntity, AuthRolePermRelRelateList }


