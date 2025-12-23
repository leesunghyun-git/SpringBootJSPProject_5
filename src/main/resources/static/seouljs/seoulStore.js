const {defineStore} = Pinia
/*
		1. Pinia 동작
		   App 생성 => createApp()
		   Pinia 등록 => defineStore()
		   store 생성
		   	| state =>  모든 Vue에서 사용하는 공통 변수 : static
			    | 변경시마다 = HTML에 적용
			  props => 불변
		각 commponent => store에 저장된 데이터를 사용
			| state변경 => html 변경
		2. 코딩
		const useSeoulStore=defineStore('seoul',{
			state:()=>({
				공통으로 사용되는 변수
				
			}),
			actions:{
				기능별 수행
				
			}
			
		})
*/
const useSeoulStore = defineStore('seoul',{
	// 공통 적용 변수 => 중복 : commons
	state:()=>({
		list:[],
		curPage:1,
		totalPage:0,
		startPage:0,
		endPage:0,
		type:1,
		detail:{}
	}),
	// 기능 설정 => axios => BASE_URL
	actions:{
		// 목록
		
		async seoulListData(type){
				this.type = type
				const res = await axios.get('http://localhost:9090/seoul/list_vue/',{
					params:{
						page:this.curPage,
						type:this.type
					}
				})
				console.log(res.data)
				this.list=res.data.list
				this.curPage=res.data.curPage
				this.totalPage=res.data.totalPage
				this.startPage=res.data.startPage
				this.endPage=res.data.endPage
				this.type=res.data.type
		},
		pageChange(page){
			this.curPage = page
			this.seoulListData(this.type)
		},
		range(start,end){
			let arr=[]
			let len=end-start
			for (let i=0;i<=len;i++)
			{
				arr.push(start)
				start++
			}
			return arr
		}
	}
})