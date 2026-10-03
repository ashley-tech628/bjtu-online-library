
interface UserDetailsParam {
    user_id: any
    user_name: any
    books: any
}
interface UserDetailsEntity {
    user_id: any
    user_name: any
    books: any
}
interface UserDetailsRelateList {
}
function createUserDetailsParam(): UserDetailsParam{
    return {
        user_id: '',
        user_name: '',
        books: '',
    }
}
function createUserDetailsEntity(): UserDetailsEntity{
    return {
        user_id: '',
        user_name: '',
        books: '',
    }
}
export function useUserDetailsModel(){
    return { createUserDetailsParam, createUserDetailsEntity,
    }
}
export type { UserDetailsParam, UserDetailsEntity, UserDetailsRelateList }

