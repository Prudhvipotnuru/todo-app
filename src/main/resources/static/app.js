async function getTodos(){
	const apiUrl = `${window.location.origin}/api/todos`;
	const response= await fetch(apiUrl);
	const todos = await response.json();
	
	const list=document.getElementById("todoList");
	list.innerHTML="";
	
	todos.forEach(todo=>{
		const li=document.createElement("li");
		const b=document.createElement("button");
		const c=document.createElement("input");
		c.type="checkbox";
		c.checked=todo.completed;
		c.onclick=()=>mark(todo.id,c.checked);
		b.onclick=()=>deleteTodos(todo.id);
		b.textContent="Delete"
		li.textContent=todo.title + " - "+todo.description+" ";
		li.append(c);
		li.append(b);
		
		list.appendChild(li);
	})
}

async function addTodo(){
	const apiUrl = `${window.location.origin}/api/todos/createTodo`;
	const title=document.getElementById("title");
	const description=document.getElementById("description");
	
	const newTodo={
		title:title.value,
		description:description.value,
		completed:false
	};
	
	await fetch(apiUrl,{
		method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newTodo)
	});
	
	getTodos();
	title.value="";
	description.value="";
}

async function deleteTodos(id){
	const apiUrl = `${window.location.origin}/api/todos/delete/`+id;
	await fetch(apiUrl);
	getTodos();
}

async function mark(id,check){
	const apiUrl = `${window.location.origin}/api/todos/mark`;
	const newTodo={
		completed:check,
		id:id
	};
	await fetch(apiUrl,{
		method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newTodo)
	});
	getTodos();
}

window.onload = getTodos;