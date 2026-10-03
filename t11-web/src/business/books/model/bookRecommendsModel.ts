
interface BookRecommendsParam {
    id: any
    code: any
}
interface BookRecommendsEntity {
    id: any
    code: any
    name: any
    isValid: any
    sortNum: any
}
interface BookRecommendsRelateList {
}
function createBookRecommendsParam(): BookRecommendsParam{
    return {
        id: '',
        code: '',
    }
}
function createBookRecommendsEntity(): BookRecommendsEntity{
    return {
        id: '',
        code: '',
        name: '',
        isValid: '',
        sortNum: '',
    }
}
export function useBookRecommendsModel(){
    return { createBookRecommendsParam, createBookRecommendsEntity,
    }
}
export type { BookRecommendsParam, BookRecommendsEntity, BookRecommendsRelateList }


