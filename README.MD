# DiscordAwards
Simple minecraft 1.8.8 discord awards plugin using **SPARK**.
Make your discord bot send a POST request to the minecraft servers IP Address and give your player a reward!

## Example usage

**NODE JS**
```javascript
const fetch = require("fetch");
const { createHash } = require('crypto');

const url = "http://<IP>:8080/award";
const secret = "SUPER_TAJNY_KOD";
let name = "DeeKaPPy";

function computeSHA256(lines) {
    const hash = createHash('sha256');

    for (let i = 0; i < lines.length; i++) {
        const line = lines[i].trim(); 
        if (line === '') continue; 
        hash.write(line); 
    }

    return hash.digest('base64');
}



fetch(url, {
        method: "POST",
        body: {
            name: name,
            hash: computeSHA256(secret + name)
        }
    })
    .then(res => res.json())
    .then(json => console.log(json));
```

## Outputs

**ERROR** \
```{"status":500, "message":"Invalid structure"}``` \
```{"status":500, "message":"Invalid hash"}``` \
```{"status":500, "message":"Invalid IP Address"}``` \
```{"status":500, "message":"Player is offline"}``` 

**SUCCESS** \
```{"status":200, "message":"Award given successfully"}```


PL: Plugin pisany z nudów, don't hate.. :D <3 