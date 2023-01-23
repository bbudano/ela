import BadgeIcon from '@mui/icons-material/Badge';
import DashboardIcon from '@mui/icons-material/Dashboard';
import GroupsIcon from '@mui/icons-material/Groups';
import TypeSpecimenIcon from '@mui/icons-material/TypeSpecimen';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import { Link } from 'react-router-dom';

export const mainDrawerItems = (
    <>
        <ListItemButton component={Link} to="/">
            <ListItemIcon>
                <DashboardIcon />
            </ListItemIcon>
            <ListItemText primary="Dashboard" />
        </ListItemButton>
        <ListItemButton component={Link} to="/teams">
            <ListItemIcon>
                <GroupsIcon />
            </ListItemIcon>
            <ListItemText primary="Teams" />
        </ListItemButton>
        <ListItemButton component={Link} to="/employees">
            <ListItemIcon>
                <BadgeIcon />
            </ListItemIcon>
            <ListItemText primary="Employees" />
        </ListItemButton>
        <ListItemButton component={Link} to="/leave-types">
            <ListItemIcon>
                <TypeSpecimenIcon />
            </ListItemIcon>
            <ListItemText primary="Leave Types" />
        </ListItemButton>
    </>
);