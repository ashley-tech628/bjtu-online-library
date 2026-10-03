
interface AuthPermParam {
    id: any
    code: any
}
interface AuthPermEntity {
    id: any
    code: any
    name: any
    isValid: any
    sortNum: any
}
interface AuthPermRelateList {
}
function createAuthPermParam(): AuthPermParam{
    return {
       id: '',
       code: '',
    }
}
function createAuthPermEntity(): AuthPermEntity{
    return {
       id: '',
       code: '',
       name: '',
       isValid: '',
       sortNum: '',
    }
}
export function useAuthPermModel(){
    return { createAuthPermParam, createAuthPermEntity,
     }
}
export type { AuthPermParam, AuthPermEntity, AuthPermRelateList }


