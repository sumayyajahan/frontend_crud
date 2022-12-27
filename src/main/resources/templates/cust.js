window.onload=function(){
    function ajaxPost(url, data, callback) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.setRequestHeader('Access-Control-Allow-Headers', '*');
        xhr.setRequestHeader('Content-type', 'application/ecmascript');
        xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
        xhr.send(data);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                callback(xhr.responseText);
            }
        }
    }

    function ajaxDelete(url, data, callback) {
        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', url, true);
        xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhr.setRequestHeader('Access-Control-Allow-Headers', '*');
        xhr.setRequestHeader('Content-type', 'application/ecmascript');
        xhr.setRequestHeader('Access-Control-Allow-Origin', '*');
        xhr.send(data);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                callback(xhr.responseText);
            }
        }
    }

    function ajaxGet(url, callback) {
        var xhr = new XMLHttpRequest();

        xhr.open('GET', url, true);
        xhr.setRequestHeader('Access-Control-Allow-Headers', '*');
        xhr.setRequestHeader('Access-Control-Allow-Origin', '*');

        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencode');
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4 && xhr.status == 200) {
                callback(xhr.responseText);
            }
        }
        xhr.send();
    }



    ajaxGet('http://localhost:8080/primeAccs', function (data) {
        var user = JSON.parse(data);



        user.forEach(e=>{
            console.log(user);
            let tr = document.createElement("tr");

            let td_id = document.createElement("td");//<td></td>
            const idText = document.createTextNode(e.employee.id);//e.id
            td_id.appendChild(idText);//<td>e.id</td>
            tr.appendChild(td_id);

            let td_name = document.createElement("td");
            const nameText = document.createTextNode(e.employee.name);
            td_name.appendChild(nameText);
            tr.appendChild(td_name);


            let td_address = document.createElement("td");
            const vAddress = document.createTextNode(e.employee.address);
            td_address.appendChild(vAddress);
            tr.appendChild(td_address);


            let td_email = document.createElement("td");
            const vEmail = document.createTextNode(e.employee.email);
            td_email.appendChild(vEmail);
            tr.appendChild(td_email);


            let td_phone = document.createElement("td");
            const vPhone = document.createTextNode(e.employee.phone);
            //td_phone.setAttribute("th:text",`${e.phone}`);
            td_phone.appendChild(vPhone);
            tr.appendChild(td_phone);


            let td_salary = document.createElement("td");
            const vSalary = document.createTextNode(e.employee.salary);
            //td_salary.setAttribute("th:text",`${e.salary}`);
            td_salary.appendChild(vSalary);
            tr.appendChild(td_salary);



            let td_accountNumber = document.createElement("td");//<td></td>
            const accountNumberText = document.createTextNode(e.accountNum);//e.id
            td_accountNumber.appendChild(accountNumberText);//<td>e.id</td>
            tr.appendChild(td_accountNumber);


            let accountTypetd = document.createElement("td");//<td></td>
            const accountTypeText = document.createTextNode(e.accountType);//e.id
            accountTypetd.appendChild(accountTypeText);//<td>e.id</td>
            tr.appendChild(accountTypetd);



            let td_Balance = document.createElement("td");//<td></td>
            const BalanceText = document.createTextNode(e.balance);//e.id
            td_Balance.appendChild(BalanceText);//<td>e.id</td>
            tr.appendChild(td_Balance);

            document.getElementById("table-body").appendChild(tr);

            //
            // <tr th:each="e: ${emp}">
            //     <th th:text="${e.id}">1</th>
            //     <td th:text="${e.name}"></td>
            //     <td th:text="${e.address}"></td>
            //     <td th:text="${e.email}"></td>
            //     <td th:text="${e.phone}"></td>
            //     <td th:text="${e.salary}"></td>
            //     <td>
            //         <a className="btn btn-small btn-primary" th:href="@{/edit/{id}(id=${e.id})}">Edit</a>
            //         <a className="btn btn-small btn-danger" th:href="@{/delete/{id}(id=${e.id})}">Delete</a>
            //     </td>
            // </tr>

            // document.getElementById("course_table_tbody").appendChild(td);

        });
    });



}