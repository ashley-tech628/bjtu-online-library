
interface BookshelfParam {
    id: any
    name: any
}
interface BookshelfEntity {
    id: any
    name: any
    allbooks: any
}
interface BookshelfRelateList {
}
function createBookshelfParam(): BookshelfParam{
    return {
        id: '',
        name: '',
    }
}
function createBookshelfEntity(): BookshelfEntity{
    return {
        id: '',
        name: '',
        allbooks: '',
    }
}
export function useBookshelfModel(){
    return { createBookshelfParam, createBookshelfEntity,
    }
}
export type { BookshelfParam, BookshelfEntity, BookshelfRelateList }

