import { useState } from "react"

const Articles =({param})=>{
    const [articles, setArticles] = useState(param);
    console.log(articles)

    return(
        <>
        </>
    )
}
export default Articles;