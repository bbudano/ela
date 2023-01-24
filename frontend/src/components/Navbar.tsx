import { AppBar, Box, Button, IconButton, Toolbar, Typography } from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import { useNavigate } from 'react-router-dom';
import { useRecoilState } from 'recoil';
import { userData } from '../App';
import { logout } from '../utils/authUtils';

type Props = {}

function Navbar({ }: Props) {

    const navigate = useNavigate();
    const [user, setUser] = useRecoilState(userData);

    const handleLogout = () => {
        logout().then(response => {
            if (typeof response === 'undefined') return;
            setUser(null);
            navigate("/login");
        })
    }

    return (
        <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            ela
          </Typography>
          <Button onClick={handleLogout} color="inherit">Logout</Button>
        </Toolbar>
      </AppBar>
    </Box>
    )
}

export default Navbar