
interface BasicFileParam {
    id: any
    groupId: any
}
interface BasicFileEntity {
    id: any
    fromType: any
    groupId: any
    name: any
    extName: any
    contentType: any
    size: any
    path: any
    isValid: any
    sortNum: any
}
interface BasicFileRelateList {
}
function createBasicFileParam(): BasicFileParam{
    return {
       id: '',
       groupId: '',
    }
}
function createBasicFileEntity(): BasicFileEntity{
    return {
       id: '',
       fromType: '',
       groupId: '',
       name: '',
       extName: '',
       contentType: '',
       size: '',
       path: '',
       isValid: '',
       sortNum: '',
    }
}
export function useBasicFileModel(){
    return { createBasicFileParam, createBasicFileEntity,
     }
}
export type { BasicFileParam, BasicFileEntity, BasicFileRelateList }


